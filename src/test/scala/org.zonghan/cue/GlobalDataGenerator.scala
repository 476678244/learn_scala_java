package org.zonghan.cue
import java.io.{BufferedWriter, File, FileWriter, OutputStream}

class GlobalDataGenerator(performer: String, title: String) extends DataGenerator {

  override def generate(fw: FileWriter): Unit = {
    val bw: BufferedWriter  = new BufferedWriter(fw)
    bw.write(s"PERFORMER ${quote(performer)}")
    bw.newLine()
    bw.write(s"TITLE ${quote(title)}")
    bw.newLine()
    bw.flush()
  }
}
