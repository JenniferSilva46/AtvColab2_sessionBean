FROM postgres
ENV POSTGRES_DB pratica02
ENV POSTGRES_USER jheycf
ENV POSTGRES_PASSWORD 222

COPY create.sql /docker-entrypoint-initdb.d/
COPY insert.sql /docker-entrypoint-initdb.d/