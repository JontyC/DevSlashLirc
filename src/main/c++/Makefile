JAVA_INCLUDE=/usr/lib/jvm/java/include
JAVAH=javah
GENERATED=../../../target/generated-sources/c++/org/harctoolbox/devslashlirc
INCLUDES = -I$(JAVA_INCLUDE) -I$(JAVA_INCLUDE)/linux -I$(GENERATED) -I/usr/local/include/lirc/include -I.
WARN=-Wall -Wextra -Werror -Wmissing-declarations
OPT=-O0
DEBUG=-g

OBJS=LircT.o IrSequence.o \
LircDevice.o Mode2LircDevice.o LircCodeLircDevice.o \
org_harctoolbox_devslashlirc_Mode2LircDevice.o \
org_harctoolbox_devslashlirc_LircCodeLircDevice.o \
org_harctoolbox_devslashlirc_LircDevice.o
#LircDriver.o LircCodeLircDriver.o Mode2LircDriver.o \
#org_harctoolbox_devslashlirc_LircDriver.o \
#org_harctoolbox_devslashlirc_Mode2LircDriver.o org_harctoolbox_devslashlirc_LircCodeLircDriver.o

#PROGS=lirconian newLircDevice reportMode2 yamaha_power_on repeat mode2dump receive


all: libdevslashlirc.so libdevslashlirc.a ../../../native/libdevslashlirc.so

org_harctoolbox_devslashlirc_LircDevice.o: $(GENERATED)/org_harctoolbox_devslashlirc_LircDevice.h
org_harctoolbox_devslashlirc_Mode2LircDevice.o: $(GENERATED)/org_harctoolbox_devslashlirc_Mode2LircDevice.h
org_harctoolbox_devslashlirc_LircCodeLircDevice.o: $(GENERATED)/org_harctoolbox_devslashlirc_LircCodeLircDevice.h


#	$(GENERATED_SRC)/org_harctoolbox_devslashlirc_LircDevice.h \
#	$(GENERATED_SRC)/org_harctoolbox_devslashlirc_LircCodeLircDevice.h \
#	$(GENERATED_SRC)/org_harctoolbox_devslashlirc_Mode2LircDevice.h \

#target/classes/org/harctoolbox/devslashlirc/%.class

$(GENERATED)/org_harctoolbox_devslashlirc_%.h:
	$(JAVAH) -o $@ -classpath ../../../target/classes org.harctoolbox.devslashlirc.$*

../../../native/libdevslashlirc.so: libdevslashlirc.so | ../../../native
	cp $< $@

../../../native:
	mkdir $@

%.o: %.cpp
	$(CXX) -o $@ $(WARN) $(INCLUDES) -fPIC $(OPT) $(DEBUG) $(CFLAGS) -c $<

#%.o: %.c
#	$(CC) -o $@ $(INCLUDES) -fPIC $(OPT) $(DEBUG) $(CFLAGS) -c $<



#lirconian: lirconian.o libdevslashlirc.so
#	$(CXX) -Wl,-rpath -Wl,. -o $@ $< -L. -ldevslashlirc

libdevslashlirc.a: $(OBJS)
	$(AR) rs $@ $(OBJS)

libdevslashlirc.so: $(OBJS)
	$(CXX) -shared -Wl,--export-dynamic -o $@ $(OBJS)

#	$(CXX) -shared -o $@ $(OBJS) -Wl,-rpath -Wl,/usr/local/lib -Wl,--export-dynamic -llirc_driver -llirc

#%: tests/%.cpp libdevslashlirc.so
#	$(CXX) -o $@ $(WARN) $(INCLUDES) -Wl,-rpath -Wl,. -O0 -g $(CFLAGS) $< -L. -ldevslashlirc

clean:
	rm -f *.o *.a *.so $(PROGS)
