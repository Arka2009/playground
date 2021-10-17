package hwbehaviour

import utest._
import chisel3._
import chisel3.util._
import chisel3.iotesters._

class ORDetailsTest(c: ORDetails) extends PeekPokeTester(c) {
    val T = 10
    var tj = 0
    while (tj < T) {
        println(s"${tj}@---------------------${peek(c.io.lfsrLeftOR)}")
        tj += 1
        step(1)
    }
}

object ORDetailsTestSuite extends TestSuite {
  val tests = Tests {
    test("build TestHarness emulator") {
      chisel3.iotesters.Driver(() => new ORDetails(32)) { c => new ORDetailsTest(c) }
    }
  }
}

// class ORDetailsSpec extends FlatSpec with Matchers {
//   behavior of "LeftOrHW"

//   it should "compute gcd excellently" in {
//     chisel3.iotesters.Driver(() => new ORDetails) { c =>
//       new ORDetailsTest(c)
//     } should be(true)
//   }
// }