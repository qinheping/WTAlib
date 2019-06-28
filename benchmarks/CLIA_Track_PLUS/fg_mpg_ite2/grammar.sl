
( synth-fun eq1  (      ( x  Int )  ( y  Int )  ( z  Int ) )  Int (
	(Start  Int (		NT1
		NT3
		NT5
		NT6
		NT10
		NT11
		NT14
))
	(NT1  Int (		x
		y
		0
		1
		z
		(ite NT4 NT1 NT1)
))
	(NT2  Int (		-x
		-y
		-1
		-z
))
	(NT3  Int (		(+ NT1 NT1)
		(+ NT1 NT2)
		(ite NT4 NT3 NT1)
		(ite NT4 NT1 NT3)
		(ite NT7 NT1 NT1)
))
	(NT4  Bool (		(>= NT1 NT1)
		(and NT4 NT4)
))
	(NT5  Int (		(+ NT3 NT1)
		(+ NT3 NT2)
		(ite NT4 NT3 NT3)
		(ite NT8 NT1 NT1)
		(ite NT4 NT5 NT1)
))
	(NT6  Int (		(+ NT3 NT3)
		(+ NT5 NT1)
		(+ NT5 NT2)
		(ite NT4 NT6 NT1)
		(ite NT9 NT1 NT1)
		(ite NT7 NT5 NT1)
		(ite NT7 NT1 NT5)
))
	(NT7  Bool (		(>= NT3 NT1)
		(and NT7 NT4)
))
	(NT8  Bool (		(>= NT3 NT3)
		(>= NT5 NT1)
		(and NT8 NT4)
		(and NT7 NT7)
))
	(NT9  Bool (		(>= NT6 NT1)
		(and NT9 NT4)
))
	(NT10  Int (		(+ NT6 NT1)
		(+ NT6 NT2)
		(ite NT12 NT1 NT1)
		(ite NT4 NT10 NT1)
))
	(NT11  Int (		(+ NT5 NT5)
		(+ NT10 NT1)
		(+ NT10 NT2)
		(ite NT8 NT6 NT1)
		(ite NT8 NT1 NT6)
		(ite NT4 NT11 NT1)
		(ite NT7 NT5 NT5)
		(ite NT15 NT1 NT1)
		(ite NT7 NT10 NT1)
))
	(NT12  Bool (		(>= NT5 NT5)
		(>= NT10 NT1)
		(and NT8 NT8)
		(and NT12 NT4)
))
	(NT13  Bool (		(>= NT6 NT6)
		(>= NT14 NT1)
		(and NT13 NT4)
		(and NT9 NT9)
))
	(NT14  Int (		(+ NT11 NT1)
		(+ NT11 NT2)
		(ite NT13 NT1 NT1)
		(ite NT8 NT10 NT1)
		(ite NT7 NT11 NT1)
		(ite NT4 NT14 NT1)
))
	(NT15  Bool (		(>= NT11 NT1)
		(and NT15 NT4)
))
))
