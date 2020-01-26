( synth-fun max4 (       ( x1  Int )  ( x2  Int )  ( x3  Int )  ( x4  Int ) )  Int (
	(Start  Int (		x1
		x2
		x3
		x4
		0
		1
		(ite NT4 NT1 NT1)
		(+ NT1 NT1)
		(ite NT3 NT1 NT1)
		(ite NT4 NT2 NT1)
		(ite NT4 NT1 NT2)
		(+ NT2 NT1)
		(ite NT3 NT2 NT1)
		(ite NT3 NT1 NT2)
		(ite NT4 NT2 NT2)
		(ite NT6 NT1 NT1)
		(ite NT4 NT5 NT1)
))
	(NT1  Int (		x1
		x2
		x3
		x4
		0
		1
		(ite NT4 NT1 NT1)
))
	(NT2  Int (		(+ NT1 NT1)
		(ite NT3 NT1 NT1)
		(ite NT4 NT2 NT1)
		(ite NT4 NT1 NT2)
))
	(NT3  Bool (		(<= NT1 NT1)
		(not NT3)
		(= NT2 NT1)
		(>= NT2 NT1)
))
	(NT4  Bool (		(= NT1 NT1)
		(>= NT1 NT1)
		(not NT4)
		(and NT4 NT4)
		(or NT4 NT4)
))
	(NT5  Int (		(+ NT2 NT1)
		(ite NT3 NT2 NT1)
		(ite NT3 NT1 NT2)
		(ite NT4 NT2 NT2)
		(ite NT6 NT1 NT1)
		(ite NT4 NT5 NT1)
))
	(NT6  Bool (		(<= NT2 NT1)
		(= NT2 NT2)
		(>= NT2 NT2)
		(and NT3 NT3)
		(or NT3 NT3)
		(not NT6)
		(= NT5 NT1)
		(>= NT5 NT1)
))
))
  ( declare-var x  Int )
  ( declare-var y  Int )
  ( declare-var z  Int )
  ( constraint  ( >=     ( max3      x  y  z )  x ) )
  ( constraint  ( >=     ( max3      x  y  z )  y ) )
  ( constraint  ( >=     ( max3      x  y  z )  z ) )
  ( constraint  ( or     ( =     x  ( max3      x  y  z ) )  ( or     ( =     y  ( max3      x  y  z ) )  ( =     z  ( max3      x  y  z ) ) ) ) )
  ( check-synth )
