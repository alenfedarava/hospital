package com.qaprosoft.hospital.models;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "cities")
@XmlEnum
public enum Cities {
	BORISOV, CHERVEN, DZERZHINSK, FANIPOL, KLETSK, KOPYL, KRYPKI, LOGOYSK, LYUBAN, MARINAGORKA, 
	MINSK, MOLODECHNO, MYADEL, NESVIZH, SLUTSK, SMOLEVICHI, SOLIGORSK, STARYYEDOROGI, STOLBTSY, UZDA, VILEYKA, VOLOZHIN, ZASLAV, ZHODINO
}
