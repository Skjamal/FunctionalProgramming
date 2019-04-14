/*import java.io._
import java.net._
import org.scalatest._
import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar


   class TestEchoServer extends FlatSpec with Matchers with MockitoSugar {
     /* "Bytes in" should "be bytes out" in {
      val serversocket = mock[ServerSocket]
      val socket = mock[Socket]
      val bytearrayinputstream = new ByteArrayInputStream("This is a test".getBytes())
      val bytearrayoutputstream = new ByteArrayOutputStream()

      when(serversocket.accept).thenReturn(socket)
      when(socket.getInputStream).thenReturn(bytearrayinputstream)
      when(socket.getOutputStream).thenReturn(bytearrayoutputstream)

      EchoServer.serve(serversocket)

      bytearrayoutputstream.toString() should be("This is a test")
     verify(socket).close()
   }
   */
     "Read This is a test" should "return error message" in {
       val in = mock[BufferedReader]
       val out = mock[BufferedWriter]

       when(in.readLine()).thenReturn("This is a test")
       EchoServer.read(in, out)
       verify(out).write("HTTP/1.0 500 \r\n")
       verify(out).write("\r\n")
       verify(out).write("Invalid Request")


     }
     "Read GET / HTTP/1.0" should "return GET / HTTP/1.0" in {
       val in = mock[BufferedReader]
       val out = mock[BufferedWriter]

       when(in.readLine()).thenReturn("GET / HTTP/1.0")
       EchoServer.read(in, out)
       verify(out).write("GET")
     }

     "Read_next with GET / HTTP/1.0" should "return HTTP/1.0 500 \r\n" in {
       val fileName = "/"
       val out = mock[BufferedWriter]
       EchoServer.read_next(fileName, out)
       verify(out).write("HTTP/1.0 500 \r\n")
       verify(out).write("r\n")
     }

     "Read_next /homepage " should "return HTTP/1.0 200 \r\n" in {
       val fileName = "test"
       val out = mock[BufferedWriter]
       v
   }

  //  BAOS.toString shouldBe("This is a test")















}

*/
