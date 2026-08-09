# OpenMMO

[![](https://dcbadge.limes.pink/api/server/SQwGXyY2gz)](https://discord.gg/SQwGXyY2gz)

> Traduction française du [README](README.md). En cas de divergence, la version
> anglaise fait foi.

## Sommaire
- [Description](#description)
- [Compilation](#compilation)
- [Configuration](#configuration)
- [Publications](#publications)
- [Documentation](#wiki)
- [Licence](LICENSE)
- [Avertissement](#avertissement)

## Description

> OpenMMO est en cours de développement et n'est pas encore prêt pour un usage réel.

OpenMMO est une implémentation open source du serveur PokeMMO.
L'objectif est de fournir une alternative libre et open source au serveur PokeMMO.

## Compilation

OpenMMO nécessite **JDK 25**. Vérifiez la version utilisée par Gradle avec
`./gradlew --version` avant de compiler. Le résolveur Foojay configuré dans le
projet télécharge automatiquement les toolchains de compilation, mais Gradle
lui-même doit être lancé par une JVM 25 ou plus récente.

Les données de cartes sont générées au moment de la compilation à partir des
projets de décompilation [pret](https://github.com/pret), intégrés comme
sous-modules git dans `decomp/`. Clonez le dépôt avec ses sous-modules :

```bash
git clone --recurse-submodules <url-du-depot>
# ou, pour un clone existant :
git submodule update --init --recursive
```

Sans les sous-modules, la compilation de `:maps` échoue, car le générateur n'a
aucune donnée de décompilation à lire.

### ROMs

Un identifiant de dialogue est un décalage (offset) dans la ROM GBA commerciale.
La décompilation lui étant identique octet pour octet, le générateur encode un
texte issu de la décompilation, retrouve ces octets dans la ROM, puis empaquette
le décalage dans l'identifiant. La décompilation seule ne contient aucun décalage.

Placez les ROMs Émeraude (`BPEE`, Hoenn) et Rouge Feu (`BPRE`, Kanto) dans
`roms/`. Les noms de fichiers n'ont pas d'importance, chaque ROM est identifiée
par le code de jeu présent dans son en-tête GBA. Le dossier est **ignoré par
git**, ce projet ne distribue aucune ROM.

Sans elles, la compilation réussit malgré tout mais chaque identifiant de
dialogue vaut `0` : la CI passe, mais le client affiche les mauvais textes.

## Configuration

Toute la configuration locale et les secrets résident dans un fichier `.env` à la
racine du dépôt. Il est **ignoré par git**, ne le committez jamais. Utilisez le
fichier versionné [`.env.example`](.env.example) comme modèle :

```bash
cp .env.example .env          # puis ajustez les valeurs
docker compose up -d          # démarre tous les conteneurs docker
./gradlew runAll              # compile et lance les serveurs
```

`runAll` lance les serveurs login et game ensemble et les arrête ensemble dès
que l'un des deux se termine. Utilisez `Ctrl-C` pour arrêter l'environnement.

Définissez `OPENMMO_ENVIRONMENT=production` dans les environnements déployés.
Le mode production refuse de démarrer si les données de développement sont
activées, si un mot de passe de base ou un secret de session par défaut subsiste,
ou si la clé privée partagée est absente. Les valeurs requises sont documentées
dans [`.env.example`](.env.example).

Pour des ajustements purement locaux de la configuration des conteneurs, créez un
fichier `docker-compose.override.yml` (également ignoré par git).
Docker Compose le fusionne automatiquement lors d'un `docker compose up`.
Pour un déploiement, fournissez un `.env` adapté et lancez
`docker compose -f docker-compose.yml up -d` afin d'ignorer toute surcharge.

### Clé serveur

Les deux serveurs partagent une même clé privée. Une compilation locale la
génère, le développement ne demande donc aucune configuration.

Les archives publiées ne contiennent aucune clé. Générez une paire avec
`./gradlew :keys:generateGame` et transmettez la clé privée aux deux serveurs via
`OPENMMO_GAME_PRIVATE_KEY` (le PEM) ou `OPENMMO_GAME_PRIVATE_KEY_FILE` (un chemin
vers celui-ci). Les clients ont besoin d'une version patchée embarquant la clé
publique correspondante.

## Publications

[release-please](https://github.com/googleapis/release-please) produit les
publications à partir de l'historique des commits. Les pull requests sont
fusionnées en squash, leurs titres deviennent donc les messages de commit qu'il
lit et doivent respecter les
[Conventional Commits](https://www.conventionalcommits.org/). La CI rejette les
titres non conformes.

`feat` incrémente la version mineure, `fix` la version corrective. En dessous de
`1.0.0`, un changement cassant incrémente la version mineure au lieu de passer
directement à `1.0.0`.

Chaque push sur `master` ouvre ou met à jour une pull request de publication. La
fusionner crée le tag de la version et y attache les archives des serveurs. La
version réside dans `gradle.properties` et s'applique à tous les modules, ne la
modifiez pas à la main.

## Wiki

Le wiki de documentation est disponible
[ici](https://openmmo.readthedocs.io/en/latest/).
Vous pouvez également y accéder via le dossier `docs` de ce dépôt.

## Avertissement
[PokeMMO](https://pokemmo.eu/) n'est affilié d'aucune manière à ce projet.
Héberger ou utiliser un serveur privé peut contrevenir aux
[CGU de PokeMMO](https://pokemmo.com/tos/).
