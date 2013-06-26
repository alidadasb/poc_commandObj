package com.example

class BookController {

    def index(BookCommand cmd) {
        println cmd.name
        println cmd.pages
        println cmd.pubDate

        render "Done"
    }
}
