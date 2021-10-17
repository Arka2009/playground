package hwbehaviour

import chisel3._
import chisel3.util._
import chisel3.util.random._
import chisel3.iotesters.PeekPokeTester

class ORDetails(val w: Int) extends Module {
    val io = IO(new Bundle{
        val lfsrOut    = Output(UInt(w.W))
        val lfsrLeftOR = Output(UInt(w.W))
    })
    val state      = LFSR(w)
    io.lfsrOut    := state
    io.lfsrLeftOR := state
}