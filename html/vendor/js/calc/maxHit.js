var maxHit=function(){this.outputRounded=null,this.outputRaw=null};maxHit.prototype.init=function(a,b){this.outputRounded=a,this.outputRaw=b},maxHit.prototype.newCalc=function(){var a=document.MaxHit.Strength.value,b=document.MaxHit.WP.value,c=document.MaxHit.Potion.value,d=document.MaxHit.Prayer.value,e=document.MaxHit.Style.value,f=(+a*+c+ +a*+d+ +e)*(.00175*+b+.1)+1.05,g=Math.ceil(+f);if(g>f)var g=g-1;else var g=g;this.outputRounded.value=+g,this.outputRaw.value=+f};