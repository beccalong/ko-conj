# ko-conj

The Wikitonary module [ko-conj](https://en.wiktionary.org/wiki/Module:ko-conj) (a Korean verb and adjective conjugator) ported into Java.

## How to conjugate a word
1. Download and compile code.  
`cd Downloads/ko-conj-master/src`  
`javac Conjugate.java`
2. Conjugate a word from the dictionary  
`java Conjugate "infinitve"`  
for example,  
`java Conjugate 걸다`  

   OR conjugate an unknown word  
   `java Conjugate "infinitive" "pos" "irregular" "regular" "hortative" "imperative" "honimperative" "honorific"`  
   for example,  
   `java Conjugate 가소롭다 A true false true true true true`
   
### Parameters

You can check the parameters for a word by checking the Wiktionary
1. Search the wikitionary for the word you're looking for, such as [하다](https://en.wiktionary.org/wiki/%ED%95%98%EB%8B%A4)
2. Next to "Conjugation", click the "edit" button
3. Find the part that says `{{ko-conj/verb}}` or `{{ko-conj/adj}}`
4. If nothing else is listed the word is regular and you should use the default parameters  
   If it says something like `{{ko-conj/adj|irreg=y}}` you should change the parameters accordingly
   - `irreg=y` means irregular = true
   - `imperative=no` means imperative = false, honimperative = false
   - `honorific=no` means honorific = false

For regular verbs/adjectives the default parameters are:  
irregular = false  
regular = false  
hortative = true  
imperative = true  
honimperative = true  
honorific = true  

## Keys
hrc: formal non-polite (해라체)  
hc: informal (familiar) non-polite (해체)  
hyc: informal (familiar) polite (해요체)  
hssoc/hsc: formal polite (하십시오체)  

ind: indicative  
interrog: interrogative  
assert: assertive  
realize: emphatic (-구나, etc.)  
cause: cause/reason  
contrast: contrast  
vn: verbal noun (um: 음, gi: 기)  
determ: determiners  

hon: honorific  
alt: alternative form  
