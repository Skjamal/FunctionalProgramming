import java.io.{BufferedReader, BufferedWriter, ByteArrayInputStream, ByteArrayOutputStream}
import java.io.OutputStreamWriter
import java.io.InputStreamReader
import java.net._
import org.scalatest._
import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar






   class TestEchoServer extends FlatSpec with Matchers with MockitoSugar {
    "Bytes in" should "be bytes out" in {
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
    "read with GET / HTTP/1.0" should "be GET" in {
      val in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream("GET / HTTP/1.0".getBytes())))
      val BAOS = new ByteArrayOutputStream()
      val out = new BufferedWriter(new OutputStreamWriter(BAOS))


    }











  }

