class TestEchoServer {
  import java.io.{BufferedReader, BufferedWriter, ByteArrayInputStream, ByteArrayOutputStream}
  import java.net._

  import org.scalatest._
  import org.mockito.Mockito._
  import org.scalatest.mockito.MockitoSugar
  import scala.io.Source


  class TestEchoServer extends FlatSpec with Matchers with MockitoSugar {
    "Bytes in" should "be bytes out" in {
      val serversocket = mock[ServerSocket]
      val socket = mock[Socket]
      val bytearrayinputstream = new ByteArrayInputStream("This is a test".getBytes())
      val bytearrayoutputstream = new ByteArrayOutputStream()

      when(serversocket.accept()).thenReturn(socket)
      when(socket.getInputStream).thenReturn(bytearrayinputstream)
      when(socket.getOutputStream).thenReturn(bytearrayoutputstream)

      EchoServer.serve(serversocket)

      bytearrayoutputstream.toString() should be("This is a test")
      verify(socket).close()
    }
    "read with hello or hello.html" should "be hello.html" in {

      SimpleWebServer.read("GET /hello HTTP/1.1") should be ("hello.html")

      SimpleWebServer.read("GET /hello.html HTTP/1.1") should be ("hello.html")

    }



    "read with /" should "be index.html" in {

      SimpleWebServer.read("GET / HTTP/1.1") should be ("index.html")

    }



    }
  }

}
