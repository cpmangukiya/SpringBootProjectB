/*This step is necessary as flyway will not auto creata a table for you also method findByRepoName is necessary */
CREATE TABLE GITHUB (
    id  IDENTITY NOT NULL PRIMARY KEY,
    org_name VARCHAR(50) NOT NULL,
    repo_name VARCHAR(100) NOT NULL UNIQUE
);

CREATE INDEX idx_repo_name on GITHUB (repo_name);
