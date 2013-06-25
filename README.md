chai-latte
==========

This library wraps the [Chai](http://chaijs.com/) assertion library, so it can be used
from ClojureScript in a convenient way.

Familiarity with the Chai library itself is assume. Refer to the [Chai guide](http://chaijs.com/guide/)
for an introduction.

```clojure
[chai-latte "0.2.0"]
```

Read the [Changelog](CHANGELOG.md) for a list of changes in the current version.

Installation
------------

When running on NodeJS, simply install Chai via npm.

    npm install chai

### Browser Support

When testing front end code in a browser or in a headless setup, you need to provide
a browser build of [chai.js](http://chaijs.com/chai.js) and any plugins to Chai that
you may be using, which are usually included via a script tag.

This library will try to autodetect if the environment is a browser or nodejs.

Examples
--------

To write an assertion construct a form of the following shape:

```clojure
(ns mylib.test.core
 (require [latte.chai :refer (expect)]))
...
(expect <actual> <test-expression> <expectation>)
```

valid forms would be:

```clojure
(expect 1 :to.equal 1)
(expect 1 :not.to.equal 2)
```

Test expressions are always keywords of dot delimited fragments. All of the Chai chainable
language constructs are available. See Chai's [expect API](http://chaijs.com/api/bdd/) as
a reference.

All values after the test expression are passed as parameters to the test method given by
the test expression. If the test epxression points to a property instead of a method,
no parameters are allowed.

```clojure
(epxect true :to.be.ok)
```

State of the Implementation
-----------------------

Currently only the [expect API](http://chaijs.com/api/bdd/) of Chai is wrapped.

### Differences From Chai

Whenever required the wrapper extends the Chai chainable language pieces to deal
with Clojure values. As an example the following is a passing assertion:

```clojure
(expect {:a 1 :b 2} :to.equal {:a 1 :b 2})
```

because Chai is extended to respect Clojure's concept of equality when dealing with
complex data structures.

Due to an implementation detail in Chai it is currently not possible to properly support
the following assertion.

```clojure
(expect [1 2 3] :to.incude 1)
```

While using this library, an additional method is present in Chai, which can be used in
the following way.

```clojure
(expect [1 2 3] :to.include.value 1)
```
