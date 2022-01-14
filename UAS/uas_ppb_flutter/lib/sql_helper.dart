import 'package:sqflite/sqflite.dart' as sql;

class SQLHelper {
  //fungsi membuat databse
  static Future<void> createTables(sql.Database database) async {
    await database.execute("""
    CREATE TABLE mahasiswa1(
      id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
      nama TEXT,
      nim TEXT,
      prodi TEXT,
      email TEXT
    )
    """);
  }

  static Future<sql.Database> db() async {
    return sql.openDatabase('mahasiswa1.db', version: 1,
        onCreate: (sql.Database database, int version) async {
          await createTables(database);
        });
  }

  // tambah data
  static Future<int> tambahMahasiswa (String nama, String nim, String prodi, String email) async {
    final db = await SQLHelper.db();
    final data = {'nama' : nama, 'nim' : nim, 'prodi' : prodi, 'email' : email};
    return await db.insert('mahasiswa1', data);
  }

  //ambil data
  static Future<List<Map<String, dynamic>>> getMahasiswa() async {
    final db = await SQLHelper.db();
    return db.query('mahasiswa1');
  }

  //fungsi ubah data
  static Future<int> ubahMahasiswa(int id, String nama, String nim, String prodi, String email) async {
    final db = await SQLHelper.db();

    final data = {
      'nama' : nama,
      'nim' : nim,
      'prodi' : prodi,
      'email' : email
    };
    return await db.update('mahasiswa1', data, where: "id = $id");
  }

  //fungsi hapus
  static Future<void> hapusMahasiswa(int id) async {
    final db = await SQLHelper.db();
    await db.delete('mahasiswa1' , where: "id = $id");
  }

}