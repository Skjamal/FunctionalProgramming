import java.net._
import java.io._
import scala.io._

object Server {
  def main(args: Array[String]) {
    val server = new ServerSocket(9999)
    while (true) {
      serve(server)
    }
  }

  def serve(server: ServerSocket) //list what the server does, it accepts the server, reads the incoming message, and sends that to another method to determine if it's a valid request
    val s = server.accept()
    val in = new BufferedReader(new InputStreamReader(s.getInputStream))
    val out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream))
    read(in)

  def read(in: BufferedReader): Unit = { //read method reads the inputstream and parses it to find the request (GET)
    val firstLine = in.readline() //firstLIne captures the entire line
    val arrayOffirstLineStrings = firstLine.split("")
      if (arrayOffirstLineStrings[0] = "GET") {
        read_next(arrayOffirstLineStrings)
      } else {
        s.close
      }
    }
  def read_next(arrayOffirstLineStrings): Unit = {
      fileName = arrayOffirstLineStrings[1]
      url = fileName.substring(1, "")

  }




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



