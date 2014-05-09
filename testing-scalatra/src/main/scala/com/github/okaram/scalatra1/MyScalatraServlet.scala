package com.github.okaram.scalatra1

import org.scalatra._
import scalate.ScalateSupport

class MyScalatraServlet extends TestingScalatraStack {

  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }
  
    get("/curri") {
        <html>
            <body>
                <h1>Hello, Curri!</h1>
                Say <a href="hello-scalate">hello to Scalate</a>.
        </body>
        </html>
    }

}
