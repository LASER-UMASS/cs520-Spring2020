# Rectangle
Example program for a software testing exercise that focuses on unit testing and
test effectiveness, using code coverage and mutation analysis.

Testing
-------
Run `./test.sh` to compile and run all test cases.

Coverage
--------
Run `./coverage.sh` to compute the coverage results.
After completion, you can view the detailed html coverage report here:
*coverage_results/index.html*

Mutation
--------
Run `./mutation.sh` to compute the mutation score.
After completion, the following files in the *mutation_results* directory provide
additional information about the generated, killed, and live mutants:

- *killed.csv*:  a summary of whether a mutant is still live or was killed with an
                 exception/assertion/timeout.

- *summary.csv*: a one-line summary that indicates how many mutants were generated
                 and killed, and how long the analysis took.

- *mutants.log*: a summary of the generated mutants (i.e., what part of the code was
                 changed and how).

Rather than reading the mutants.log file, you can visualize the source code
differences between a mutant and the original program by running:
`./show_mutant.sh <mutant ID>`

For example, the following command shows how mutant 1 differs from the original
(i.e., unmutated) program:
`./show_mutant.sh 1`

The output is a unified diff that indicates what line the mutation changed:
```
--- src/Rectangle.java 2020-11-04 09:38:56.000000000 -0500
+++ .mutated/mutants/1/Rectangle.java		     2020-11-04 09:47:33.000000000 -0500
@@ -24 +24 @@
-      if ((width <= 0) || (height <= 0)) {
+      	  if ((width < 0) || (height <= 0)) {
```
The line starting with `@@` indicates the line number of the changed source code
line (24 in this example). The line starting with `- ` shows the removed line,
and the line starting with `+ ` shows the line that replaced it.
