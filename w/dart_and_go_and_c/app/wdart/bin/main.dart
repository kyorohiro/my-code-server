import 'dart:ffi' as ffi;

typedef PrintHello_func = ffi.Void Function();
typedef PrintHello = void Function();

void main(List<String> arguments) {
  var path = "/app/wgo/libhello.so";
  ffi.DynamicLibrary dylib = ffi.DynamicLibrary.open(path);
  final PrintHello hello = dylib
      .lookup<ffi.NativeFunction<PrintHello_func>>('PrintHello')
      .asFunction();
  hello();
}

