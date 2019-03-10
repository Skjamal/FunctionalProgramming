import java.net._
import java.io._
import scala.io._

object Server {
  def main(args: Array[String]) {
    val server = new ServerSocket(9999)
    
    while (true) {
      val s = server.accept()
      println("Successful connection")
      val in = new BufferedSource(s.getInputStream()).getLines()
      println(in.next)
      val out = new PrintStream(s.getOutputStream())



      def read_and_write(in: BufferedReader, out:BufferedWriter): Unit = {
        out.write(in.readLine())
        out.flush()
        in.close()
        out.close()

      }
      out.println(in.next())
      out.flush()
      s.close()
    }
  }
}



