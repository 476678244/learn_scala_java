package org.zonghan.cue

import java.io.{File, FileWriter}

object CueFileGenerator extends App {

  val dir: String = "/Users/zwu/Music/齐秦/齐秦1997 狼 97黄金自选辑"

  val performer: String = "齐秦"

  val album: String = "狼97黄金自选辑"

  val musicType: String = ".wav"

  val cueFilePath = s"${dir}/cue.cue"

  val skipStr = s"_FR725SACD_2ch256"

  val cueFile = new File(cueFilePath)
  if (cueFile.exists())
    cueFile.delete()
  cueFile.createNewFile()

  val fw = new FileWriter(cueFilePath)
  try {
    new GlobalDataGenerator(performer, album).generate(fw)
    val validFiles = new File(dir).listFiles().filter(f => {
      !f.getName.startsWith(".")
    }).sortBy(f => {
      f.getName
    })
    val validFileNames = validFiles.filter(f => {
      f.isFile && f.getName.endsWith(musicType)
    }).map(_.getName)
    validFiles.zipWithIndex.foreach(data => {
      val (f, i) = data
      if (f.isFile && f.getName.endsWith(musicType)) {
        val rawTitle = f.getName.replace(musicType, "")
        val startSub = Math.max(
          if (rawTitle.indexOf(".") > 0)
            rawTitle.indexOf(".")
          else {
            Math.max(rawTitle.indexOf("."), {
              if (rawTitle.indexOf("-") > 0)
                rawTitle.indexOf("-") + 1
              else if (rawTitle.indexOf("_") > 0)
                rawTitle.indexOf("_") + 1
              else
                0
            }
            )
          },
          0
        )
        var trackTitle = rawTitle.substring(startSub).trim.replace(skipStr, "")
        if (findCommon(validFileNames.toList).nonEmpty) {
          trackTitle = trackTitle.replace(findCommon(validFileNames.toList), "")
        }
        trackTitle = trackTitle.trim
        new TrackItemDataGenerator(performer, trackTitle, f.getName, (i + 1).toString).generate(fw)
      }
    })
  } finally {
    fw.close()
  }

  def findCommon(names: List[String]): String = {
    if (isCommon(names, "-")) {
      // find via left
      var common = "-"
      var tryCommon = names.head(names.head.indexOf(common) - 1).toString + common
      while (isCommon(names, tryCommon)) { // until is not common
        common = tryCommon
        if (names.head.indexOf(common) == 0)
          return common
        tryCommon = names.head(names.head.indexOf(common) - 1).toString + common
      }
      common
    } else ""
  }

  def isCommon(names: List[String], sub: String): Boolean = {
    names.map(n => {
      if (n.contains(sub)) 1 else 0
    }).sum == names.length
  }

}
