## Метод `Math.round()`
Метод `Math.round()` используется для округления числа до ближайшего целого значения. Он работает следующим образом:
- Если десятичная часть числа меньше 0.5, то число округляется вниз до ближайшего целого значения.
- Если десятичная часть числа больше или равна 0.5, то число округляется вверх до ближайшего целого значения.

```java
double number = 2.3;
long roundedNumber = Math.round(number);
System.out.println(roundedNumber); // Output: 2

number = 4.8;
roundedNumber = Math.round(number);
System.out.println(roundedNumber); // Output: 5
```

## Метод `Math.floor()`
Метод `Math.floor()`  используется для округления числа вниз до ближайшего целого значения. Он работает следующим образом:
- Округляет число всегда вниз до ближайшего целого значения, независимо от десятичной части числа.


```java
double number = 2.3;
long roundedNumber = Math.round(number);
System.out.println(roundedNumber); // Output: 2

number = 4.8;
roundedNumber = Math.round(number);
System.out.println(roundedNumber); // Output: 5