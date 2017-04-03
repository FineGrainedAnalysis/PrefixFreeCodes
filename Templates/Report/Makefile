#*  thesis



#** General:
all: thesis.ps thesis.pdf
	@make -i grep
grep:
	@echo "** Warnings Summary:"
	@grep Warning thesis.log
e: 
	emacs -geometry 200x100 thesis.tex & make gv
tgz: thesis.tgz


publish:  thesis.ps thesis.pdf
	scp thesis.ps thesis.pdf cpu102.cs:~/public_html/Recherche/Publishing/Preprints/  
thesis.tgz: clean
	rm -f thesis.tgz
	tar -czvf  thesis.tgz ./* 
	@echo "Use tar -xzvf  thesis.tgz to extract"
	scp thesis.tgz cpu102.cs:~/tmp/

#** Article:
xpdf: thesis.pdf
	xpdf thesis.pdf &
gv:  thesis.ps
	gv  thesis.ps &
thesis.pdf: thesis.ps
	ps2pdf thesis.ps
thesis.ps: thesis.dvi
	dvips -q -o thesis.ps thesis.dvi
thesis.dvi: thesis.toc thesis.bbl figures
	latex thesis 
thesis.bbl: thesis.toc 
	bibtex -terse thesis
thesis.toc: thesis.tex
	latex thesis 

figures:
	@echo Pas de figures.
# cd Figures && make && cd ..


#** Nettoyage:
clean:
	rm -f thesis.ps thesis.pdf
	rm -f *.aux *.log *.bbl *.rel *~ *.ind *.idx
	rm -f *.dvi *.blg *.toc
	rm -f *.loa *.lof *.ilg
	rm -rf auto thesis.nav thesis.out thesis.snm
#	cd Figures && make clean && cd ..
