# Liquibase example

This simple example shows how to use [liquibase](https://www.liquibase.org/index.html) and [liquibase maven plugin](https://www.liquibase.org/documentation/maven/index.html).

For running this example necessary to have MySQL database. 

In folder *v0_0_1* are shown how used liquibase for creating tables and inserting data in them. Then these configuration files included in *db.changelog-master.xml* using [*include*](http://www.liquibase.org/documentation/include.html) tag.

Folder *v0_0_2* also contains scripts for creating tables and inserting data. But these configuration files included in *db.changelog-master.xml* using [*includeAll*](http://www.liquibase.org/documentation/includeall.html) tag. And this tag contains attribute *resourceComparator* with value *com.github.pavzay.liquibase.comparator.ChangeLogComparator*. It is custom comparator which defines how will execute liquibase changelog files.


#### [Contexts](https://www.liquibase.org/documentation/contexts.html)


In file *2019-01-25_1211_insertEmployeeStubData_local.xml* tag *changeSet* contains attribute *context* with value *local*.
This attribute define which scope of change sets will execute after running liquibase. 

If we launch liquibase without parameter context then all files will be executed.

`mvn clean install`

If we launch liquibase with parameter `-Dliquibase.contexts='!local'` then all files will be executed without those that contains context *local*. 

```mvn clean install -e -Dliquibase.contexts='!local'```
