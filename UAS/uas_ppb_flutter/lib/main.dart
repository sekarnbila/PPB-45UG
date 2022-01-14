import 'package:flutter/material.dart';
import 'package:uas_ppb_flutter/sql_helper.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key key}) : super(key: key);


  @override
  Widget build(BuildContext context) {
    return MaterialApp(

      debugShowCheckedModeBanner: false,
      title: 'CRUD SQLite',
      theme: ThemeData(

          primarySwatch: Colors.blueGrey,
          scaffoldBackgroundColor: const Color(0x1D153D15)
      ),
      home: const MyHomePage(title: 'DATA MAHASISWA FLUTTER'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key key, @required this.title}) : super(key: key);



  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  TextEditingController namaController = TextEditingController();
  TextEditingController nimController = TextEditingController();
  TextEditingController prodiController = TextEditingController();
  TextEditingController emailController = TextEditingController();

  @override
  void initState() {
    refreshMahasiswa();
    super.initState();
  }

  //ambil data dri dtabase
  List<Map<String, dynamic>> mahasiswa = [];
  void refreshMahasiswa() async {
    final data = await SQLHelper.getMahasiswa();
    setState(() {
      mahasiswa = data;
    });
  }



  @override
  Widget build(BuildContext context) {
    print(mahasiswa);
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: ListView.builder(
          itemCount: mahasiswa.length,
          itemBuilder: (context, index) => Card (
            margin: const EdgeInsets.all(12),
            child: ListTile(
              isThreeLine : true,
              title: Text(mahasiswa[index]['nama'], style: TextStyle(fontWeight: FontWeight.bold)),
              subtitle : Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(mahasiswa[index]['nim'], style: TextStyle(fontWeight: FontWeight.bold)),
                  Text(mahasiswa[index]['prodi']),
                  Text(mahasiswa[index]['email']),
                ],
              ),

              trailing: SizedBox(
                width: 100,
                child: Row(
                  children: [
                    IconButton(
                        onPressed: () => modalForm(mahasiswa[index]['id']),
                        icon: const Icon(Icons.border_color)),
                    IconButton(
                        onPressed: () => hapusMahasiswa(mahasiswa[index]['id']),
                        icon: const Icon(Icons.delete))
                  ],
                ),),
            ),
          )),
      floatingActionButton: FloatingActionButton(
        onPressed: (){
          modalForm(null);
        },
        // tooltip: 'Increment',
        child: const Icon(Icons.add_box),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }

  //fungsi tambah data
  Future<void> tambahMahasiswa() async {
    await SQLHelper.tambahMahasiswa(namaController.text, nimController.text, prodiController.text, emailController.text);
    refreshMahasiswa();
  }

  //fungsi update data
  Future<void> ubahMahasiswa(int id) async {
    await SQLHelper.ubahMahasiswa(id, namaController.text, nimController.text, prodiController.text, emailController.text);
    refreshMahasiswa();
  }

  //fungsi hapus data
  void hapusMahasiswa(int id) async {
    await SQLHelper.hapusMahasiswa(id);
    ScaffoldMessenger.of(context)
        .showSnackBar(const SnackBar(content: Text("Berhasil menghapus data")));
    refreshMahasiswa();
  }

  //form tambah
  void modalForm(int id) async {
    if(id!=null) {
      final dataMahasiswa = mahasiswa.firstWhere((element) => element['id'] == id);
      namaController.text = dataMahasiswa['nama'];
      nimController.text = dataMahasiswa['nim'];
      prodiController.text = dataMahasiswa['prodi'];
      emailController.text = dataMahasiswa['email'];
    }
    showModalBottomSheet(context: context, builder: (_)=> Container(
      padding: const EdgeInsets.all(15),
      width: double.infinity,
      height: 800,
      child: SingleChildScrollView(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.end,
          children: [
            TextField(
              controller: namaController,
              decoration: const InputDecoration(hintText: "Masukkan Nama Mahasiswa"),
            ),
            const SizedBox(height: 10,
            ),
            TextField(
              controller: nimController,
              decoration: const InputDecoration(hintText: "Masukkan Nim Mahasiswa"),
            ),
            const SizedBox(height: 20,
            ),
            TextField(
              controller: prodiController,
              decoration: const InputDecoration(hintText: "Masukkan Prodi Mahasiswa"),
            ),
            const SizedBox(height: 10,
            ),
            TextField(
              controller: emailController,
              decoration: const InputDecoration(hintText: "Masukkan Email Mahasiswa"),
            ),
            const SizedBox(height: 10,
            ),
            ElevatedButton(onPressed: () async {
              if(id == null) {
                await tambahMahasiswa();
              }else {
                await ubahMahasiswa(id);
              }
              namaController.text = '';
              nimController.text = '';
              prodiController.text = '';
              emailController.text = '';
              Navigator.pop(context);
            },
                child: Text(id== null ? 'tambah' : 'ubah')),
          ],
        ),
      ),
    ));
  }
}
