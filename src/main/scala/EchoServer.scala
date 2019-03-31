import java.io._
import java.net._
import scala.io._


object EchoServer {
  def main(args: Array[String]): Unit ={
    val server = new ServerSocket(9999)
    while (true) {
      serve(server)
    }
  }

  def serve(server: ServerSocket): Unit ={ //the ServerSocket listens for client requests
    val s = server.accept() //the server accepts the clients connection
    val in = new BufferedReader(new InputStreamReader(s.getInputStream)) //val in = the data the client sends out to the server
    val out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream)) //val out = the data the server sends out to the client
    read(in, out) //send the data coming in from the client to be read in the read method
    s.close()
  }
  def read(in: BufferedReader, out: BufferedWriter): Unit = { //read method reads the inputstream and parses it to find the request (GET)
    val firstLine = in.readLine() //firstLIne captures the entire line including the ('\r\n')
    var arrayOfFirstLineStrings = (firstLine.split("\\s+")) //this parses the first line by space and returns a list of strings

    if (arrayOfFirstLineStrings(0) == "GET") { //if the first string in the array is the HTTP request "GET",
      read_next(arrayOfFirstLineStrings, out) //then send the array to the method read_next
    }
    else { //if not "GET"
      out.write("HTTP/1.0 500 \r\n")
      out.write("\r\n")
    }
  }

  def read_next(arrayOfFirstLineStrings: Array[String], out: BufferedWriter): Unit = { //read_next method
    val url = arrayOfFirstLineStrings(1) //the file name is contained within the second string in the array
    val fileName = url.substring(1) //the url is the file name begins after the "/" in /index.html}
    output(out, fileName) //
  }

  def output(out: BufferedWriter, fileName: String): Unit = {
    if (fileName == null) { //if file is not index.html then it will return null
      out.write("HTTP/1.0 404 Not Found \r\n") //return 404 error
      out.write("\r\n")
    }
    else {
      val file = scala.io.Source.fromFile("input.html")
      val lines = scala.io.Source.fromFile("file.txt", "utf-8").getLines.mkString
      out.write("HTTP/1.0 200 Ok \r\n") //if it index.html then return 200 response
      out.write("\r\n")
      out.write(lines)

    }
    out.flush()

  }


}
