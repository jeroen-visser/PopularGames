# Popular games

A simple app which will load populair games from the igdb.com API, store it locally and shows a list
to the screen in a RecyclerView. You can click on a game which will navigate you to the
detail fragment.

## Architecture

![Architecture](docs/architecture.png)

## Installation steps

1. Set the credentials in the gradle.properties file
2. Run the app!

## Steps I took to implement

1. Add navigation and Fragments
2. DI with Hilt
3. Add ViewModel
4. Remote data with Retrofit
5. Local storage with Room

## Missing

1. Add tests!!
2. Add pagination with Paging
3. Filter based on genres