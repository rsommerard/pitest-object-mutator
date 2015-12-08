# Pitest-object-mutator

Opérateurs de mutation objet pour Pitest.

# Preface

Rendre les scripts exécutables: `chmod +x run.sh clean.sh clean-hard.sh`

Le script clean-hard.sh n'est à utiliser qu'en cas de bug. Il supprime entièrement
le dossier .m2 de l'utilisateur.

# Tester une mutation

1. Indiquer le type de mutant dans le pom.xml. Par exemple:
    ```xml
    <mutator>ACCESS_MODIFIER_CHANGES</mutator>
    ```

2. Lancer le script run.sh.

  ```bash
  ./run.sh
  ```

3. Les résultats de pitest se trouvent dans le dossier:
    `<project_name>/target/pit-reports/`

# Liens

- http://fr.slideshare.net/royvanrijn/kill-the-mutants-a-better-way-to-test-your-tests
