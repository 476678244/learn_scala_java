package org.zonghan.cue
import java.io.{BufferedWriter, FileWriter}

class TrackItemDataGenerator(performer: String, title: String, fileName: String, order: String) extends DataGenerator {

  override def generate(fw: FileWriter): Unit = {
    val bw: BufferedWriter  = new BufferedWriter(fw)
    bw.write(s"FILE ${quote(fileName)} WAVE")
    bw.newLine()
    bw.write(s"  TRACK ${order} AUDIO")
    bw.newLine()
    bw.write(s"    TITLE ${quote(title)}")
    bw.newLine()
    bw.write(s"    PERFORMER ${quote(performer)}")
    bw.newLine()
    bw.write(s"    INDEX 01 00:00:00")
    bw.newLine()
    bw.flush()
  }
}
