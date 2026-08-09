CREATE TABLE social_friends (
  user_id     INT         NOT NULL,
  friend_name VARCHAR(32) NOT NULL,
  PRIMARY KEY (user_id, friend_name)
);

CREATE TABLE social_blocks (
  user_id      INT          NOT NULL,
  blocked_name VARCHAR(32)  NOT NULL,
  reason       VARCHAR(128) NOT NULL DEFAULT '',
  PRIMARY KEY (user_id, blocked_name)
);

CREATE TABLE guilds (
  id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  name       VARCHAR(32)  NOT NULL UNIQUE,
  tag        VARCHAR(8)   NOT NULL UNIQUE,
  motd       VARCHAR(512) NOT NULL DEFAULT '',
  founded_at INT          NOT NULL,
  updated_at INT          NOT NULL
);

CREATE TABLE guild_members (
  guild_id     BIGINT      NOT NULL REFERENCES guilds (id) ON DELETE CASCADE,
  character_id BIGINT      NOT NULL REFERENCES characters (id) ON DELETE CASCADE,
  name         VARCHAR(32) NOT NULL,
  rank         VARCHAR(16) NOT NULL,
  leader       BOOLEAN     NOT NULL DEFAULT FALSE,
  joined_at    INT         NOT NULL,
  PRIMARY KEY (guild_id, character_id),
  CONSTRAINT uq_guild_members_character UNIQUE (character_id)
);

CREATE TABLE guild_rank_permissions (
  guild_id   BIGINT      NOT NULL REFERENCES guilds (id) ON DELETE CASCADE,
  rank       VARCHAR(16) NOT NULL,
  permission VARCHAR(32) NOT NULL,
  PRIMARY KEY (guild_id, rank, permission)
);

CREATE TABLE guild_rank_labels (
  guild_id BIGINT       NOT NULL REFERENCES guilds (id) ON DELETE CASCADE,
  rank     VARCHAR(16)  NOT NULL,
  label    VARCHAR(32)  NOT NULL,
  PRIMARY KEY (guild_id, rank)
);

CREATE TABLE guild_activity_log (
  id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  guild_id   BIGINT       NOT NULL REFERENCES guilds (id) ON DELETE CASCADE,
  event_type INT          NOT NULL,
  actor      VARCHAR(32)  NOT NULL,
  target     VARCHAR(32)  NOT NULL DEFAULT '',
  created_at INT          NOT NULL
);

CREATE INDEX idx_guild_activity_log_guild ON guild_activity_log (guild_id, id);
