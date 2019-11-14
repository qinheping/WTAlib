; constraint : w1 < 1.0
  ( set-logic LIA )
( synth-fun max4  (      ( x  Int )  ( y  Int )  ( z  Int ) )  Int (
	(Start  Int (		x
		y
		0
		1
		z
		(+ NT1 NT1)
		(- NT1 NT1)
		(ite NT2 NT1 NT1)
		(+ NT3 NT1)
		(- NT3 NT1)
))
	(NT1  Int (		x
		y
		0
		1
		z
		(+ NT1 NT1)
		(- NT1 NT1)
))
	(NT2  Bool (		(<= NT1 NT1)
		(= NT1 NT1)
		(>= NT1 NT1)
		(not NT2)
		(and NT2 NT2)
		(or NT2 NT2)
))
	(NT3  Int (		(ite NT2 NT1 NT1)
		(+ NT3 NT1)
		(- NT3 NT1)
))
))
  ( declare-var x  Int )
  ( declare-var y  Int )
  ( declare-var z  Int )
  ( constraint  ( >=     ( max4      x  y  z )  x ) )
  ( constraint  ( >=     ( max4      x  y  z )  y ) )
  ( constraint  ( >=     ( max4      x  y  z )  z ) )
  ( constraint  ( or     ( =     x  ( max4      x  y  z ) )  ( or     ( =     y  ( max4      x  y  z ) )  ( =     z  ( max4      x  y  z ) ) ) ) )
  ( check-synth )
