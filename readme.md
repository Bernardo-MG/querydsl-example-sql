# Querydsl Example with SQL

Using the Querydsl DSL to handle SQL queries. These queries are handled through the tests.

[![Release docs](https://img.shields.io/badge/docs-release-blue.svg)][site-release]
[![Development docs](https://img.shields.io/badge/docs-develop-blue.svg)][site-develop]

## Database support

Three databases are used to test the queries:

- h2
- Mysql
- Postgres

These, except for h2, should be started before running the tests. Which can be done with Docker:

```
docker-compose -f docker/docker-compose.yml --project-name querydsl-example-sql up
```

## Running the queries

There is a profile for each database:

- h2
- mysql
- postgres

Just run the tests with the profile desired:

```
mvn clean verify -Pmysql
```

## Features

- SQL queries with Querydsl

## Documentation

Documentation is always generated for the latest release, kept in the 'master' branch:

- The [latest release documentation page][site-release].

Documentation is also generated from the latest snapshot, taken from the 'develop' branch:

- The [latest snapshot documentation page][site-develop].

The documentation site is actually a Maven site, and its sources are included in the project. If required it can be generated by using the following Maven command:

```
mvn verify site
```

The verify phase is required, otherwise some of the reports won't be generated.

### Installing

The archetype can be installed with the following Maven coordinates:

```
Group ID: com.bernardomg.maven.archetypes
Artifact ID: library-archetype
Version: (Check POM or badges)
```

For example, to use it through command line type the following:

```
mvn archetype:generate -DarchetypeGroupId=com.bernardomg.maven.archetypes -DarchetypeArtifactId=library-archetype -DarchetypeVersion=[version]
```

If using an IDE check its documentation to find out how to use Maven Archetypes, and how to add these to the local repository.

As an alternative, it is always possible to download the project from Github, and then install it using the usual Maven command:

```
mvn install
```

### Running tests

The archetype plugin comes ready to run integration tests for the archetype by using the usual Maven command:

```
mvn verify
```

Check the [archetype testing goal][archetype-testing] for more info.

If using Eclipse the tests may not run, due to an incompatibility with the Maven Invoker library. It is recommender running the tests through command line.

## Collaborate

Any kind of help with the project will be well received, and there are two main ways to give such help:

- Reporting errors and asking for extensions through the issues management
- or forking the repository and extending the project

### Issues management

Issues are managed at the GitHub [project issues tracker][issues], where any Github user may report bugs or ask for new features.

### Getting the code

If you wish to fork or modify the code, visit the [GitHub project page][scm], where the latest versions are always kept. Check the 'master' branch for the latest release, and the 'develop' for the current, and stable, development version.

## License
The project has been released under the [MIT License][license].

[issues]: https://github.com/Bernardo-MG/library-maven-archetype/issues
[license]: https://www.opensource.org/licenses/mit-license.php
[scm]: https://github.com/Bernardo-MG/library-maven-archetype
[site-develop]: https://docs.bernardomg.com/development/maven/library-maven-archetype
[site-release]: https://docs.bernardomg.com/maven/library-maven-archetype

[surefire]: https://maven.apache.org/surefire/maven-surefire-plugin/
[failsafe]: https://maven.apache.org/surefire/maven-failsafe-plugin/
