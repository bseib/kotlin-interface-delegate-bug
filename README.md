# kotlin-interface-delegate-bug
A reproduction of a kotlin bug involving delgates of an interface

## Description

If you have an interface with a function defined, and you create an object instance of that
interface using a delegate, then when you call the interface's function, the receiver is not
the delegate, but the original object.

## How to recreate

Run the unit test in `TestFavoritesWithDelegates`. There are comments in that file
as well as the `Favorites` interface that point out what's going on.

