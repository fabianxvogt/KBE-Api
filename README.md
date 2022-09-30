# KBE - Shopping App (Api)

### Run the project locally

Execute ```docker build -t kbe/shoppingapp .``` in the root folder of the project to build the Docker container. 


Then start it by running ```docker run -p 8080:8080 kbe/shoppingapp ```

We are using a MongoDB Atlas Database to host our data and therefore are dependent on using MongoRepositories.

For local execution, you can also use Redis in-memory store. This Repo already contains a RedisConfig file, so you only need to change the datatypes of the Repositories from ```MongoRepository``` to ```CrudRepository```.

