# ko-conj

The Wikitonary module ko-conj (a Korean verb and adjective conjugator) ported into Java.

## How to conjugate a word
1. Download and compile code.
2. Conjugate a word from the dictionary  
`java Conjugate "infinitve"`  
for example,  
`java Conjugate 걸다`  

   OR conjugate an unknown word  
   `java Conjugate "infinitive" "pos" "irregular" "regular" "hortative" "imperative" "honimperative" "honorific"`  
   for example,  
   `java Conjugate 가소롭다 A true false true true true true`

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
