import java.net._
import java.io._
import scala.io.


object Server {
  def serve(server: ServerSocket) { //the ServerSocket listens for client requests
    val s = server.accept() //the server accepts the clients connection
    val in = new BufferedReader(new InputStreamReader(s.getInputStream)) //val in = the data the client sends out to the server
    val out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream)) //val out = the data the server sends out to the client
    read(in) //send the data coming in from the client to be read in the read method
  }

    def read(in: BufferedReader): Unit = { //read method reads the inputstream and parses it to find the request (GET)
      val firstLine = in.readLine() //firstLIne captures the entire line including the ('\r\n')
      var arrayOffirstLineStrings = Array(firstLine.split("\\s+")) //this parses the first line by space and returns a list of strings

      if (arrayOffirstLineStrings(0) == "GET") { //if the first string in the array is the HTTP request "GET",
        read_next(arrayOffirstLineStrings) //then send the array to the method read_next
      }
      else { //if not "GET"
        s.close // disconnect
      }
    }
    def read_next(arrayOfFirstLineStrings: Array[String]): Unit = { //read_next method
      val url = arrayOffirstLineStrings(1)  //the file name is contained within the second string in the array
      val fileName = url.substring(1) //the url is the file name begins after the "/" in /index.html}
    }

    def output(out: BufferedWriter): Unit = {
      if (fileName == null) {
        out.write("HTTP/1.0 404 Not Found \r\n")
        out.write("\r\n")
      }
      else {
        out.write("HTTP/1.0 200 Ok \r\n")
        write("\r\n")
      }
      out.flush
      s.close
    }


    def main(args: Array[String]) {
      val server = new ServerSocket(9999)
      while (true) {
        serve(server)
      }
    }
  }










