package eu.jeroenvisser.populargames.data.repository

import eu.jeroenvisser.populargames.data.entities.Cover
import eu.jeroenvisser.populargames.data.entities.Game

class GameRepository {
    fun games(): List<Game> {

        val listOfGames = ArrayList<Game>()

        listOfGames.add(
            Game(
                id = 1020,
                cover = Cover(
                    height = 800,
                    url = "https://images.igdb.com/igdb/image/upload/t_720p/co1tgt.jpg",
                    width = 600
                ),
                title = "Grand Theft Auto V",
                description = "The biggest, most dynamic and most diverse open world ever created, Grand Theft Auto V blends storytelling and gameplay in new ways as players repeatedly jump in and out of the lives of the game’s three lead characters, playing all sides of the game’s interwoven story.",
                rating = 91.0273498404548,
                ratingCount = 2753,
            )
        )
        listOfGames.add(
            Game(
                id = 1942,
                cover = Cover(
                    height = 1559,
                    url = "https://images.igdb.com/igdb/image/upload/t_720p/co1wyy.jpg",
                    width = 1170
                ),
                title = "The Witcher 3: Wild Hunt",
                description = "RPG and sequel to The Witcher 2 (2011), The Witcher 3 follows witcher Geralt of Rivia as he seeks out his former lover and his young subject while intermingling with the political workings of the wartorn Northern Kingdoms. Geralt has to fight monsters and deal with people of all sorts in order to solve complex problems and settle contentious disputes, each ranging from the personal to the world-changing.",
                rating = 95.72089289853591,
                ratingCount = 2443,
            )
        )
        listOfGames.add(
            Game(
                id = 472,
                cover = Cover(
                    height = 800,
                    url = "https://images.igdb.com/igdb/image/upload/t_720p/co1tnw.jpg",
                    width = 600
                ),
                title = "The Elder Scrolls V: Skyrim",
                description = "The next chapter in the highly anticipated Elder Scrolls saga arrives from the makers of the 2006 and 2008 Games of the Year, Bethesda Game Studios. Skyrim reimagines and revolutionizes the open-world fantasy epic, bringing to life a complete virtual world open for you to explore any way you choose.  \n \nPlay any type of character you can imagine, and do whatever you want; the legendary freedom of choice, storytelling, and adventure of The Elder Scrolls is realized like never before.  \n \nSkyrim’s new game engine brings to life a complete virtual world with rolling clouds, rugged mountains, bustling cities, lush fields, and ancient dungeons.  \n \nChoose from hundreds of weapons, spells, and abilities. The new character system allows you to play any way you want and define yourself through your actions.  \n \nBattle ancient dragons like you’ve never seen. As Dragonborn, learn their secrets and harness their power for yourself.",
                rating = 87.7155344657797,
                ratingCount = 2166,
            )
        )
        listOfGames.add(
            Game(
                id = 72,
                cover = Cover(
                    height = 1948,
                    url = "https://images.igdb.com/igdb/image/upload/t_720p/co1rs4.jpg",
                    width = 1461
                ),
                title = "Portal 2",
                description = "Sequel to the acclaimed Portal (2007), Portal 2 pits the protagonist of the original game, Chell, and her new robot friend, Wheatley, against more puzzles conceived by GLaDOS, an A.I. with the sole purpose of testing the Portal Gun's mechanics and taking revenge on Chell for the events of Portal. As a result of several interactions and revelations, Chell once again pushes to escape Aperture Science Labs.",
                rating = 91.3236043528061,
                ratingCount = 2100,
            )
        )
        listOfGames.add(
            Game(
                id = 71,
                cover = Cover(
                    height = 1200,
                    url = "https://images.igdb.com/igdb/image/upload/t_720p/co1x7d.jpg",
                    width = 900
                ),
                title = "Portal",
                description = "Waking up in a seemingly empty laboratory, the player is made to complete various physics-based puzzle challenges through numerous test chambers in order to test out the new Aperture Science Handheld Portal Device, without an explanation as to how, why or by whom.",
                rating = 87.1191986251528,
                ratingCount = 1901,
            )
        )
        listOfGames.add(
            Game(
                id = 732,
                cover = Cover(
                    height = 800,
                    url = "https://images.igdb.com/igdb/image/upload/t_720p/co1tgw.jpg",
                    width = 600
                ),
                title = "Grand Theft Auto: San Andreas",
                description = "Returning after his mother's murder to the semi-fictional city of Los Santos (based on Los Angeles), Carl Johnson, a former gang banger, must take back the streets for his family and friends by gaining respect and once again gaining control over the streets. However, a story filled with crime, lies and corruption will lead him to trudge the entire state of San Andreas (based on California and Nevada) to rebuild his life.",
                rating = 90.3509775714489,
                ratingCount = 1854,
            )
        )
        listOfGames.add(
            Game(
                id = 1009,
                cover = Cover(
                    height = 3857,
                    url = "https://images.igdb.com/igdb/image/upload/t_720p/co1r7f.jpg",
                    width = 2893
                ),
                title = "The Last of Us",
                description = "A third person shooter/stealth/survival hybrid, in which twenty years after the outbreak of a parasitic fungus which takes over the neural functions of humans, Joel, a Texan with a tragic familial past, finds himself responsible with smuggling a fourteen year old girl named Ellie to a militia group called the Fireflies, while avoiding strict and deadly authorities, infected fungal hosts and other violent survivors.",
                rating = 94.54930276451509,
                ratingCount = 1815,
            )
        )
        listOfGames.add(
            Game(
                id = 233,
                cover = Cover(
                    height = 1008,
                    url = "https://images.igdb.com/igdb/image/upload/t_720p/co1nmw.jpg",
                    width = 756
                ),
                title = "Half-Life 2",
                description = "1998. HALF-LIFE sends a shock through the game industry with its combination of pounding action and continuous, immersive storytelling. \n \nNOW. By taking the suspense, challenge and visceral charge of the original, and adding startling new realism and responsiveness, Half-Life 2 opens the door to a world where the player's presence affects everything around him, from the physical environment to the behaviors even the emotions of both friends and enemies.",
                rating = 90.9215348474151,
                ratingCount = 1764,
            )
        )
        listOfGames.add(
            Game(
                id = 20,
                cover = Cover(
                    height = 1915,
                    url = "https://images.igdb.com/igdb/image/upload/t_720p/co1rs0.jpg",
                    width = 1436
                ),
                title = "BioShock",
                description = "Set in the Objectivist underwater dystopia of Rapture in the '60's, Bioshock is a first-person shooter with the premise of arming and genetically modifying yourself in order to survive against the city's resident great minds-turned-maddened anomalies and aid Atlas in his mission to overthrow the city's cruel ruler, Andrew Ryan.",
                rating = 87.7979846709618,
                ratingCount = 1671,
            )
        )
        listOfGames.add(
            Game(
                id = 127,
                cover = Cover(
                    height = 1415,
                    url = "https://images.igdb.com/igdb/image/upload/t_720p/co1rcf.jpg",
                    width = 1061
                ),
                title = "Assassin's Creed II",
                description = "Discover an intriguing and epic story of power, revenge and conspiracy set during a pivotal moment in history: the Italian Renaissance. \nExperience the freedom and immersion of an all new open world and mission structure with settings such as the rooftops and canals of beautiful Venice. Your options in combat, assassination and escape are vast, with many new weapons, settings and gameplay elements.",
                rating = 87.38664843868919,
                ratingCount = 1628,
            )
        )

        return listOfGames

    }
}