package boopickle.perftests

import boopickle.Default._
import pushka.json._
import io.circe.generic.auto._

object Tests {
  val tree = TestData.genTree(5, 3)
  val suites = Seq(
    PerfTestSuite("Encode single Seq[Int]", Seq(
      BooPickleRunners.encodeRunner(Seq(3)),
      PrickleRunners.encodeRunner(Seq(3)),
      UPickleRunners.encodeRunner(Seq(3)),
      CirceRunners.encodeRunner(Seq(3)),
      PushkaRunners.encodeRunner(Seq(3))
    )),
    PerfTestSuite("Decode single Seq[Int]", Seq(
      BooPickleRunners.decodeRunner(Seq(3)),
      PrickleRunners.decodeRunner(Seq(3)),
      UPickleRunners.decodeRunner(Seq(3)),
      CirceRunners.decodeRunner(Seq(3)),
      PushkaRunners.decodeRunner(Seq(3))
    )),
    PerfTestSuite("Encode very large Seq[Int]", Seq(
      BooPickleRunners.encodeRunner(TestData.largeIntSeq),
      PrickleRunners.encodeRunner(TestData.largeIntSeq),
      UPickleRunners.encodeRunner(TestData.largeIntSeq),
      CirceRunners.encodeRunner(TestData.largeIntSeq),
      PushkaRunners.encodeRunner(TestData.largeIntSeq)
    )),
    PerfTestSuite("Decode very large Seq[Int]", Seq(
      BooPickleRunners.decodeRunner(TestData.largeIntSeq),
      PrickleRunners.decodeRunner(TestData.largeIntSeq),
      UPickleRunners.decodeRunner(TestData.largeIntSeq),
      CirceRunners.decodeRunner(TestData.largeIntSeq),
      PushkaRunners.decodeRunner(TestData.largeIntSeq)
    )),
    PerfTestSuite("Encode large Seq[Double]", Seq(
      BooPickleRunners.encodeRunner(TestData.largeDoubleSeq),
      PrickleRunners.encodeRunner(TestData.largeDoubleSeq),
      UPickleRunners.encodeRunner(TestData.largeDoubleSeq),
      CirceRunners.encodeRunner(TestData.largeDoubleSeq),
      PushkaRunners.encodeRunner(TestData.largeDoubleSeq)
    )),
    PerfTestSuite("Decode large Seq[Double]", Seq(
      BooPickleRunners.decodeRunner(TestData.largeDoubleSeq),
      PrickleRunners.decodeRunner(TestData.largeDoubleSeq),
      UPickleRunners.decodeRunner(TestData.largeDoubleSeq),
      CirceRunners.decodeRunner(TestData.largeDoubleSeq),
      PushkaRunners.decodeRunner(TestData.largeDoubleSeq)
    )),
    PerfTestSuite("Encode large Seq[Float]", Seq(
      BooPickleRunners.encodeRunner(TestData.largeFloatSeq),
      PrickleRunners.encodeRunner(TestData.largeFloatSeq),
      UPickleRunners.encodeRunner(TestData.largeFloatSeq),
      CirceRunners.encodeRunner(TestData.largeFloatSeq),
      PushkaRunners.encodeRunner(TestData.largeFloatSeq)
    )),
    PerfTestSuite("Decode large Seq[Float]", Seq(
      BooPickleRunners.decodeRunner(TestData.largeFloatSeq),
      PrickleRunners.decodeRunner(TestData.largeFloatSeq),
      UPickleRunners.decodeRunner(TestData.largeFloatSeq),
      CirceRunners.decodeRunner(TestData.largeFloatSeq),
      PushkaRunners.decodeRunner(TestData.largeFloatSeq)
    )),
    PerfTestSuite("Encode an object tree", Seq(
      BooPickleRunners.encodeRunner(tree),
      PrickleRunners.encodeRunner(tree),
      UPickleRunners.encodeRunner(tree),
      // CirceRunners.encodeRunner(tree),
      PushkaRunners.encodeRunner(tree)
    )),
    PerfTestSuite("Decode an object tree", Seq(
      BooPickleRunners.decodeRunner(tree),
      PrickleRunners.decodeRunner(tree),
      UPickleRunners.decodeRunner(tree),
      // CirceRunners.decodeRunner(tree),
      PushkaRunners.decodeRunner(tree)
    )),
    PerfTestSuite("Encode very large Map[String, Int]", List(
      BooPickleRunners.encodeRunner(TestData.largeStringIntMap),
      PrickleRunners.encodeRunner(TestData.largeStringIntMap),
      UPickleRunners.encodeRunner(TestData.largeStringIntMap),
      CirceRunners.encodeRunner(TestData.largeStringIntMap),
      PushkaRunners.encodeRunner(TestData.largeStringIntMap)
    )),
    PerfTestSuite("Decode very large Map[String, Int]", List(
      BooPickleRunners.decodeRunner(TestData.largeStringIntMap),
      PrickleRunners.decodeRunner(TestData.largeStringIntMap),
      UPickleRunners.decodeRunner(TestData.largeStringIntMap),
      CirceRunners.decodeRunner(TestData.largeStringIntMap),
      PushkaRunners.decodeRunner(TestData.largeStringIntMap)
    )),
    PerfTestSuite("Encoding Seq[Book] with random IDs", Seq(
      BooPickleRunners.encodeRunner(TestData.booksRandomID),
      PrickleRunners.encodeRunner(TestData.booksRandomID),
      UPickleRunners.encodeRunner(TestData.booksRandomID),
      CirceRunners.encodeRunner(TestData.booksRandomID),
      PushkaRunners.encodeRunner(TestData.booksRandomID)
    )),
    PerfTestSuite("Decoding Seq[Book] with random IDs", Seq(
      BooPickleRunners.decodeRunner(TestData.booksRandomID),
      PrickleRunners.decodeRunner(TestData.booksRandomID),
      UPickleRunners.decodeRunner(TestData.booksRandomID),
      CirceRunners.decodeRunner(TestData.booksRandomID),
      PushkaRunners.decodeRunner(TestData.booksRandomID)
    )),
    PerfTestSuite("Encoding Seq[Book] with UUIDs", Seq(
      BooPickleRunners.encodeRunner(TestData.booksUUID),
      PrickleRunners.encodeRunner(TestData.booksUUID),
      UPickleRunners.encodeRunner(TestData.booksUUID),
      CirceRunners.encodeRunner(TestData.booksUUID),
      PushkaRunners.encodeRunner(TestData.booksUUID)
    )),
    PerfTestSuite("Decoding Seq[Book] with UUIDs", Seq(
      BooPickleRunners.decodeRunner(TestData.booksUUID),
      PrickleRunners.decodeRunner(TestData.booksUUID),
      UPickleRunners.decodeRunner(TestData.booksUUID),
      CirceRunners.decodeRunner(TestData.booksUUID),
      PushkaRunners.decodeRunner(TestData.booksUUID)
    )),
    PerfTestSuite("Encoding Seq[Book] with numerical IDs", Seq(
      BooPickleRunners.encodeRunner(TestData.booksNumId),
      PrickleRunners.encodeRunner(TestData.booksNumId),
      UPickleRunners.encodeRunner(TestData.booksNumId),
      CirceRunners.encodeRunner(TestData.booksNumId),
      PushkaRunners.encodeRunner(TestData.booksNumId)
    )),
    PerfTestSuite("Decoding Seq[Book] with numerical IDs", Seq(
      BooPickleRunners.decodeRunner(TestData.booksNumId),
      PrickleRunners.decodeRunner(TestData.booksNumId),
      UPickleRunners.decodeRunner(TestData.booksNumId),
      CirceRunners.decodeRunner(TestData.booksNumId),
      PushkaRunners.decodeRunner(TestData.booksNumId)
    ))
  )
}
