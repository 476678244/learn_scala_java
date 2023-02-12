package org.zonghan.cue

import java.io.{File, FileWriter, OutputStream}

trait DataGenerator {

  def generate(fw: FileWriter)

  def quote(s: String) = "\"" + s + "\""
}
