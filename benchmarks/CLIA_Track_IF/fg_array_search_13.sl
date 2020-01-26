(set-logic LIA)
( synth-fun findIdx  (                 ( x1  Int )  ( x2  Int )  ( x3  Int )  ( x4  Int )  ( x5  Int )  ( x6  Int )  ( x7  Int )  ( x8  Int )  ( x9  Int )  ( x10  Int )  ( x11  Int )  ( x12  Int )  ( x13  Int )  ( k  Int ) )  Int (
	(Start  Int (		x1
		x2
		x3
		x12
		x4
		x5
		x13
		0
		x6
		x7
		x8
		x9
		k
		x10
		x11
		1
		(+ NT1 NT1)
		(ite NT2 NT1 NT1)
		(+ NT3 NT1)
		(+ NT4 NT1)
		(+ NT3 NT3)
		(ite NT2 NT3 NT1)
		(ite NT5 NT1 NT1)
		(+ NT4 NT4)
		(+ NT7 NT1)
		(ite NT5 NT4 NT1)
		(ite NT5 NT1 NT4)
		(ite NT2 NT8 NT1)
		(ite NT20 NT1 NT1)
		(ite NT2 NT4 NT1)
		(ite NT6 NT1 NT1)
		(+ NT8 NT1)
		(+ NT10 NT1)
		(ite NT2 NT9 NT1)
		(ite NT5 NT4 NT4)
		(ite NT5 NT7 NT1)
		(ite NT6 NT8 NT1)
		(+ NT8 NT8)
		(ite NT21 NT1 NT1)
		(+ NT7 NT7)
		(ite NT2 NT11 NT1)
		(+ NT13 NT1)
		(ite NT6 NT9 NT1)
		(ite NT5 NT10 NT1)
		(ite NT12 NT8 NT1)
		(ite NT12 NT1 NT8)
		(ite NT23 NT1 NT1)
		(+ NT15 NT1)
		(+ NT10 NT10)
		(ite NT5 NT14 NT1)
		(ite NT2 NT17 NT1)
		(ite NT6 NT16 NT1)
		(ite NT12 NT11 NT1)
		(ite NT12 NT1 NT11)
		(ite NT27 NT1 NT1)
		(ite NT20 NT13 NT1)
		(ite NT20 NT1 NT13)
		(ite NT2 NT13 NT1)
		(ite NT6 NT10 NT1)
		(ite NT5 NT11 NT1)
		(+ NT16 NT1)
		(ite NT12 NT7 NT1)
		(ite NT12 NT1 NT7)
		(ite NT19 NT1 NT1)
		(ite NT2 NT15 NT1)
		(+ NT18 NT1)
		(ite NT6 NT14 NT1)
		(ite NT5 NT17 NT1)
		(ite NT12 NT7 NT7)
		(ite NT12 NT13 NT1)
		(ite NT25 NT1 NT1)
		(ite NT20 NT16 NT1)
		(ite NT20 NT1 NT16)
		(+ NT9 NT1)
		(ite NT2 NT7 NT1)
		(ite NT6 NT4 NT1)
		(ite NT6 NT1 NT4)
		(ite NT12 NT1 NT1)
		(ite NT5 NT8 NT1)
		(+ NT11 NT1)
		(ite NT2 NT10 NT1)
		(ite NT6 NT4 NT4)
		(ite NT6 NT7 NT1)
		(ite NT5 NT9 NT1)
		(ite NT22 NT1 NT1)
		(+ NT14 NT1)
		(+ NT9 NT9)
		(ite NT6 NT11 NT1)
		(ite NT5 NT13 NT1)
		(ite NT2 NT16 NT1)
		(ite NT12 NT9 NT1)
		(ite NT12 NT1 NT9)
		(ite NT26 NT1 NT1)
		(ite NT2 NT14 NT1)
		(+ NT17 NT1)
		(ite NT6 NT13 NT1)
		(ite NT5 NT16 NT1)
		(ite NT12 NT10 NT1)
		(ite NT12 NT1 NT10)
		(ite NT24 NT1 NT1)
		(ite NT12 NT8 NT8)
))
	(NT1  Int (		x1
		x2
		x3
		x12
		x4
		x5
		x13
		0
		x6
		x7
		x8
		x9
		k
		x10
		x11
		1
		(+ NT1 NT1)
))
	(NT2  Bool (		(<= NT1 NT1)
		(not NT2)
		(and NT2 NT2)
		(or NT2 NT2)
))
	(NT3  Int (		(ite NT2 NT1 NT1)
		(+ NT3 NT1)
))
	(NT4  Int (		(+ NT4 NT1)
		(+ NT3 NT3)
		(ite NT2 NT3 NT1)
		(ite NT5 NT1 NT1)
))
	(NT5  Bool (		(<= NT3 NT1)
		(not NT5)
		(and NT5 NT2)
		(or NT5 NT2)
))
	(NT6  Bool (		(<= NT4 NT1)
		(<= NT3 NT3)
		(not NT6)
		(and NT6 NT2)
		(or NT6 NT2)
		(and NT5 NT5)
		(or NT5 NT5)
))
	(NT7  Int (		(+ NT4 NT4)
		(+ NT7 NT1)
		(ite NT5 NT4 NT1)
		(ite NT5 NT1 NT4)
		(ite NT2 NT8 NT1)
		(ite NT20 NT1 NT1)
))
	(NT8  Int (		(ite NT2 NT4 NT1)
		(ite NT6 NT1 NT1)
		(+ NT8 NT1)
))
	(NT9  Int (		(+ NT9 NT1)
		(ite NT2 NT7 NT1)
		(ite NT6 NT4 NT1)
		(ite NT6 NT1 NT4)
		(ite NT12 NT1 NT1)
		(ite NT5 NT8 NT1)
))
	(NT10  Int (		(+ NT10 NT1)
		(ite NT2 NT9 NT1)
		(ite NT5 NT4 NT4)
		(ite NT5 NT7 NT1)
		(ite NT6 NT8 NT1)
		(+ NT8 NT8)
		(ite NT21 NT1 NT1)
))
	(NT11  Int (		(+ NT11 NT1)
		(ite NT2 NT10 NT1)
		(ite NT6 NT4 NT4)
		(ite NT6 NT7 NT1)
		(ite NT5 NT9 NT1)
		(ite NT22 NT1 NT1)
))
	(NT12  Bool (		(<= NT4 NT4)
		(<= NT7 NT1)
		(and NT6 NT6)
		(or NT6 NT6)
		(not NT12)
		(and NT12 NT2)
		(or NT12 NT2)
))
	(NT13  Int (		(+ NT7 NT7)
		(ite NT2 NT11 NT1)
		(+ NT13 NT1)
		(ite NT6 NT9 NT1)
		(ite NT5 NT10 NT1)
		(ite NT12 NT8 NT1)
		(ite NT12 NT1 NT8)
		(ite NT23 NT1 NT1)
))
	(NT14  Int (		(+ NT14 NT1)
		(+ NT9 NT9)
		(ite NT6 NT11 NT1)
		(ite NT5 NT13 NT1)
		(ite NT2 NT16 NT1)
		(ite NT12 NT9 NT1)
		(ite NT12 NT1 NT9)
		(ite NT26 NT1 NT1)
))
	(NT15  Int (		(+ NT15 NT1)
		(+ NT10 NT10)
		(ite NT5 NT14 NT1)
		(ite NT2 NT17 NT1)
		(ite NT6 NT16 NT1)
		(ite NT12 NT11 NT1)
		(ite NT12 NT1 NT11)
		(ite NT27 NT1 NT1)
		(ite NT20 NT13 NT1)
		(ite NT20 NT1 NT13)
))
	(NT16  Int (		(ite NT2 NT13 NT1)
		(ite NT6 NT10 NT1)
		(ite NT5 NT11 NT1)
		(+ NT16 NT1)
		(ite NT12 NT7 NT1)
		(ite NT12 NT1 NT7)
		(ite NT19 NT1 NT1)
))
	(NT17  Int (		(ite NT2 NT14 NT1)
		(+ NT17 NT1)
		(ite NT6 NT13 NT1)
		(ite NT5 NT16 NT1)
		(ite NT12 NT10 NT1)
		(ite NT12 NT1 NT10)
		(ite NT24 NT1 NT1)
		(ite NT12 NT8 NT8)
))
	(NT18  Int (		(ite NT2 NT15 NT1)
		(+ NT18 NT1)
		(ite NT6 NT14 NT1)
		(ite NT5 NT17 NT1)
		(ite NT12 NT7 NT7)
		(ite NT12 NT13 NT1)
		(ite NT25 NT1 NT1)
		(ite NT20 NT16 NT1)
		(ite NT20 NT1 NT16)
))
	(NT19  Bool (		(<= NT7 NT7)
		(<= NT13 NT1)
		(not NT19)
		(and NT19 NT2)
		(or NT19 NT2)
		(and NT12 NT12)
		(or NT12 NT12)
))
	(NT20  Bool (		(<= NT8 NT1)
		(not NT20)
		(and NT20 NT2)
		(or NT20 NT2)
))
	(NT21  Bool (		(<= NT9 NT1)
		(not NT21)
		(and NT21 NT2)
		(or NT21 NT2)
))
	(NT22  Bool (		(<= NT10 NT1)
		(<= NT8 NT8)
		(not NT22)
		(and NT22 NT2)
		(or NT22 NT2)
		(and NT20 NT20)
		(or NT20 NT20)
))
	(NT23  Bool (		(<= NT11 NT1)
		(not NT23)
		(and NT23 NT2)
		(or NT23 NT2)
))
	(NT24  Bool (		(<= NT14 NT1)
		(<= NT9 NT9)
		(not NT24)
		(and NT24 NT2)
		(or NT24 NT2)
		(and NT21 NT21)
		(or NT21 NT21)
))
	(NT25  Bool (		(<= NT15 NT1)
		(<= NT10 NT10)
		(not NT25)
		(and NT25 NT2)
		(or NT25 NT2)
		(and NT22 NT22)
		(or NT22 NT22)
))
	(NT26  Bool (		(<= NT16 NT1)
		(not NT26)
		(and NT26 NT2)
		(or NT26 NT2)
))
	(NT27  Bool (		(<= NT17 NT1)
		(not NT27)
		(and NT27 NT2)
		(or NT27 NT2)
))
))
(declare-var x1 Int)
(declare-var x2 Int)
(declare-var x3 Int)
(declare-var x4 Int)
(declare-var x5 Int)
(declare-var x6 Int)
(declare-var x7 Int)
(declare-var x8 Int)
(declare-var x9 Int)
(declare-var x10 Int)
(declare-var x11 Int)
(declare-var x12 Int)
(declare-var x13 Int)
(declare-var k Int)
(constraint (=> (and (< x1 x2) (and (< x2 x3) (and (< x3 x4) (and (< x4 x5) (and (< x5 x6) (and (< x6 x7) (and (< x7 x8) (and (< x8 x9) (and (< x9 x10) (and (< x10 x11) (and (< x11 x12) (< x12 x13)))))))))))) (=> (< k x1) (= (findIdx x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 x11 x12 x13 k) 0))))
(constraint (=> (and (< x1 x2) (and (< x2 x3) (and (< x3 x4) (and (< x4 x5) (and (< x5 x6) (and (< x6 x7) (and (< x7 x8) (and (< x8 x9) (and (< x9 x10) (and (< x10 x11) (and (< x11 x12) (< x12 x13)))))))))))) (=> (> k x13) (= (findIdx x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 x11 x12 x13 k) 13))))
(constraint (=> (and (< x1 x2) (and (< x2 x3) (and (< x3 x4) (and (< x4 x5) (and (< x5 x6) (and (< x6 x7) (and (< x7 x8) (and (< x8 x9) (and (< x9 x10) (and (< x10 x11) (and (< x11 x12) (< x12 x13)))))))))))) (=> (and (> k x1) (< k x2)) (= (findIdx x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 x11 x12 x13 k) 1))))
(constraint (=> (and (< x1 x2) (and (< x2 x3) (and (< x3 x4) (and (< x4 x5) (and (< x5 x6) (and (< x6 x7) (and (< x7 x8) (and (< x8 x9) (and (< x9 x10) (and (< x10 x11) (and (< x11 x12) (< x12 x13)))))))))))) (=> (and (> k x2) (< k x3)) (= (findIdx x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 x11 x12 x13 k) 2))))
(constraint (=> (and (< x1 x2) (and (< x2 x3) (and (< x3 x4) (and (< x4 x5) (and (< x5 x6) (and (< x6 x7) (and (< x7 x8) (and (< x8 x9) (and (< x9 x10) (and (< x10 x11) (and (< x11 x12) (< x12 x13)))))))))))) (=> (and (> k x3) (< k x4)) (= (findIdx x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 x11 x12 x13 k) 3))))
(constraint (=> (and (< x1 x2) (and (< x2 x3) (and (< x3 x4) (and (< x4 x5) (and (< x5 x6) (and (< x6 x7) (and (< x7 x8) (and (< x8 x9) (and (< x9 x10) (and (< x10 x11) (and (< x11 x12) (< x12 x13)))))))))))) (=> (and (> k x4) (< k x5)) (= (findIdx x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 x11 x12 x13 k) 4))))
(constraint (=> (and (< x1 x2) (and (< x2 x3) (and (< x3 x4) (and (< x4 x5) (and (< x5 x6) (and (< x6 x7) (and (< x7 x8) (and (< x8 x9) (and (< x9 x10) (and (< x10 x11) (and (< x11 x12) (< x12 x13)))))))))))) (=> (and (> k x5) (< k x6)) (= (findIdx x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 x11 x12 x13 k) 5))))
(constraint (=> (and (< x1 x2) (and (< x2 x3) (and (< x3 x4) (and (< x4 x5) (and (< x5 x6) (and (< x6 x7) (and (< x7 x8) (and (< x8 x9) (and (< x9 x10) (and (< x10 x11) (and (< x11 x12) (< x12 x13)))))))))))) (=> (and (> k x6) (< k x7)) (= (findIdx x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 x11 x12 x13 k) 6))))
(constraint (=> (and (< x1 x2) (and (< x2 x3) (and (< x3 x4) (and (< x4 x5) (and (< x5 x6) (and (< x6 x7) (and (< x7 x8) (and (< x8 x9) (and (< x9 x10) (and (< x10 x11) (and (< x11 x12) (< x12 x13)))))))))))) (=> (and (> k x7) (< k x8)) (= (findIdx x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 x11 x12 x13 k) 7))))
(constraint (=> (and (< x1 x2) (and (< x2 x3) (and (< x3 x4) (and (< x4 x5) (and (< x5 x6) (and (< x6 x7) (and (< x7 x8) (and (< x8 x9) (and (< x9 x10) (and (< x10 x11) (and (< x11 x12) (< x12 x13)))))))))))) (=> (and (> k x8) (< k x9)) (= (findIdx x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 x11 x12 x13 k) 8))))
(constraint (=> (and (< x1 x2) (and (< x2 x3) (and (< x3 x4) (and (< x4 x5) (and (< x5 x6) (and (< x6 x7) (and (< x7 x8) (and (< x8 x9) (and (< x9 x10) (and (< x10 x11) (and (< x11 x12) (< x12 x13)))))))))))) (=> (and (> k x9) (< k x10)) (= (findIdx x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 x11 x12 x13 k) 9))))
(constraint (=> (and (< x1 x2) (and (< x2 x3) (and (< x3 x4) (and (< x4 x5) (and (< x5 x6) (and (< x6 x7) (and (< x7 x8) (and (< x8 x9) (and (< x9 x10) (and (< x10 x11) (and (< x11 x12) (< x12 x13)))))))))))) (=> (and (> k x10) (< k x11)) (= (findIdx x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 x11 x12 x13 k) 10))))
(constraint (=> (and (< x1 x2) (and (< x2 x3) (and (< x3 x4) (and (< x4 x5) (and (< x5 x6) (and (< x6 x7) (and (< x7 x8) (and (< x8 x9) (and (< x9 x10) (and (< x10 x11) (and (< x11 x12) (< x12 x13)))))))))))) (=> (and (> k x11) (< k x12)) (= (findIdx x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 x11 x12 x13 k) 11))))
(constraint (=> (and (< x1 x2) (and (< x2 x3) (and (< x3 x4) (and (< x4 x5) (and (< x5 x6) (and (< x6 x7) (and (< x7 x8) (and (< x8 x9) (and (< x9 x10) (and (< x10 x11) (and (< x11 x12) (< x12 x13)))))))))))) (=> (and (> k x12) (< k x13)) (= (findIdx x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 x11 x12 x13 k) 12))))
(check-synth)
