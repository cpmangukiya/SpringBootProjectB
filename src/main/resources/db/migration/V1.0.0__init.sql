/*This step is necessary as flyway will not auto create a table for you also method findByRepoName is necessary */
CREATE TABLE GITHUB (
    id IDENTITY NOT NULL PRIMARY KEY,
    org_name VARCHAR(50) NOT NULL,
    repo_name VARCHAR(100) NOT NULL UNIQUE
);

CREATE INDEX idx_repo_name on GITHUB (repo_name);

CREATE TABLE SAMPLE_TABLE (
    ID NUMBER(10) NOT NULL PRIMARY KEY,
    NAME VARCHAR(100) NOT NULL UNIQUE
);

create sequence hibernate_sequence start with 1 increment by 1;
