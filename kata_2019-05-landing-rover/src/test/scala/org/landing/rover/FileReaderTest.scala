package org.landing.rover

import org.scalatest.{ Matchers, WordSpec }

class FileReaderTest extends WordSpec with Matchers {

  "CommonUtils" should {
    "throw an IllegalArgumentException for filename which does not exists" in {
      val filename = "a-filename-that-does-not-exist.txt"
      an[IllegalArgumentException] should be thrownBy FileReader.read(filename)
    }
    "extract the content from a file" in {
      val filename = "input-file.txt"
      val actual   = FileReader.read(filename)
      actual should contain theSameElementsAs Seq(
        "This is a test input file.",
        "Second line",
        "Third line"
      )
    }
  }
}
