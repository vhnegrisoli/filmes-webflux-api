FROM gradle:6.6.1-jdk11 AS build
COPY --chown=gradle:gradle . /usr/filmes-api/src
WORKDIR /usr/filmes-api/src
RUN gradle build
CMD ["gradle", "bootRun"]