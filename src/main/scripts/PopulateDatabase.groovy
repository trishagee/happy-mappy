import org.mongodb.MongoClients
import org.mongodb.connection.ServerAddress

// ONLY FOR PROTOTYPING
def mongoClient = MongoClients.create(new ServerAddress())
def collection = mongoClient.getDatabase("MongoDBHappinessIndex").getCollection("ProcessedPoints")
collection.tools().drop()

//def xmlSlurper = new XmlSlurper().parse(new File('resources/all-coffee-shops.xml'))
//
//xmlSlurper.node.each { child ->
//    Map coffeeShop = ['openStreetMapId': child.@id.text(),
//                      'location'       : ['coordinates': [Double.valueOf(child.@lon.text()), Double.valueOf(child.@lat.text())],
//                                          'type'       : 'Point']]
//    child.tag.each { theNode ->
//        coffeeShop.put(theNode.@k.text(), theNode.@v.text())
//    }
//    if (coffeeShop.name != null) {
//        println coffeeShop
//        collection.insert(new Document(coffeeShop))
//    }
//}
//
//println "\nTotal imported: $collection.count"
//
//collection.createIndex(new Document('location', '2dsphere'))
//
