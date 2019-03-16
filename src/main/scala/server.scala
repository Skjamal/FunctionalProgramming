import java.net._
import java.io._
import scala.io._


object Server {
  def main(args: Array[String]) {
    val server = new ServerSocket(9999)
    while (true) {
      serve(server)
    }

  def serve(server: ServerSocket) { //list what the server does, it accepts the server, reads the incoming message, and sends that to another method to determine if it's a valid request
    val s = server.accept()
    val in = new BufferedReader(new InputStreamReader(s.getInputStream))
    val out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream))
    read(in)
  }

  def read(in: BufferedReader): Unit = {    //read method reads the inputstream and parses it to find the request (GET)
    val firstLine = in.readLine() //firstLIne captures the entire line
    var arrayOffirstLineStrings = Array(firstLine.split("\\s+")) //this parses the first line and creates an array of strings
      println(arrayOffirstLineStrings(0)) //
      if (arrayOffirstLineStrings(0) == "GET") { //if the first string is the HTTP request "GET",
        read_next(arrayOffirstLineStrings(1)) //then send the second string to the method read_next
      }
    else {
      s.close   //else disconnect
    }
  }
  def read_next(arrayOfFirstLineStrings:Array[String]): Unit = { //read_next method
    val url = arrayOffirstLineStrings(1)  //the file name is contained within the second string in the array
    val fileName = url.substring(1)  //the url is the file name begins after the "/" in /index.html

  def output(out: BufferedWriter): Unit ={
    if (fileName == null) {
      out.write("HTTP/1.0 404 Not Found \r\n")
      out.write("\r\n")
    }
     else out.write("HTTP/1.0 200 Ok \r\n")
      write("\r\n")
      out.flush
      s.close






    }
  }
}



