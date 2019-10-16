( synth-fun eq1  (             ( x1  Int )  ( x2  Int )  ( x3  Int )  ( x4  Int )  ( x5  Int )  ( x6  Int )  ( x7  Int )  ( x8  Int )  ( x9  Int )  ( x10  Int ) )  Int (
	(Start  Int (		NT1
		NT3
))
	(NT1  Int (		0
		1
		(+ NT1 NT1)
		(ite NT4 NT1 NT1)
))
	(NT2  Int (		x1
		x2
		x3
		x4
))
	(NT3  Int (		(+ NT1 NT2)
		(+ NT3 NT1)
		(ite NT5 NT1 NT1)
		(ite NT4 NT3 NT1)
		(ite NT4 NT1 NT3)
))
	(NT4  Bool (		(>= NT1 NT1)
		(not NT4)
		(or NT4)
		(and NT4 NT4)
))
	(NT5  Bool (		(>= NT3 NT1)
		(not NT5)
		(or NT5)
		(and NT5 NT4)
))
))