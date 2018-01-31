FROM postgres:9.6 

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY docker-entrypoint-initdb.d/* /docker-entrypoint-initdb.d/  

# Make port 80 available to the world outside this container
EXPOSE 5432

# Define environment variable
ENV POSTGRES_PASSWORD=p
ENV PGPASSWORD=p

# Run app.py when the container launches
# CMD ["psql -U postgres -h postgres -w -f postgres-coffeeshop-creation.sql", "psql -U postgres -h postgres -w -d coffeeshop -f postgres-schema.sql"]
