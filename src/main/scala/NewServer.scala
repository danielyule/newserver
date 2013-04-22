import akka.dispatch.Future
import blueeyes.BlueEyesServiceBuilder
import blueeyes.core.data.{ByteChunk, BijectionsChunkString, BijectionsChunkXML, IdentityBijections, BijectionsChunkFutureString, _}
import blueeyes.core.http.HttpStatusCodes.BadRequest
import blueeyes.core.http.MimeTypes.{html, text, json, application}
import blueeyes.core.http.{HttpStatus, HttpResponse, HttpRequest}
import blueeyes.json.JsonAST._

import blueeyes.json.JsonAST.JField
import blueeyes.json.JsonAST.JString
import blueeyes.json.Printer._
import java.io.{OutputStreamWriter, ByteArrayOutputStream}
import scala.Some
import scala.Some
import scala.xml.NodeSeq
import scala.io.Source


trait NewService extends BlueEyesServiceBuilder with BijectionsChunkJson with BijectionsChunkFutureJson {


  val newService = service("New Service", "0.0.1") {
    context =>
      (startup {
        Future {
          ()
        }
      } ->
        request { config: Unit =>

          path("/(.*)") {

            contentType[JValue, ByteChunk](application/json) {
              get {
                (req: HttpRequest[Future[JValue]]) => {
                  val jstring = JString("Hello World!")
                  val jfield = JField("result", jstring)
                  val jobject = JObject(jfield :: Nil)

                  Future{HttpResponse[JValue](content = Some(jobject))}
                }
              }
            }

          }
        } ->
        shutdown { config =>
          println("Shutting down")
          Future { () }
        })

  }
}

import blueeyes.BlueEyesServer

class NewServer

object NewServer extends BlueEyesServer with NewService
