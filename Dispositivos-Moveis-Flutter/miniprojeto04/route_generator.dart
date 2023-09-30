import 'package:atm_consultoria/views/cliente.dart';
import 'package:atm_consultoria/views/contato.dart';
import 'package:atm_consultoria/views/servicos.dart';
import 'package:flutter/material.dart';
import 'package:atm_consultoria/views/home.dart';
import 'package:atm_consultoria/views/empresa.dart';

class RouteGenerator {
  static Route<dynamic> generateRoute(RouteSettings settings) {
    switch (settings.name) {
      case "/":
        return MaterialPageRoute(builder: (_) => const HomeView());

      case "/empresa_view":
        return MaterialPageRoute(builder: (_) => const EmpresaView());

      case "/servico_view":
        return MaterialPageRoute(builder: (_) => const ServicoView());

      case "/contato_view":
        return MaterialPageRoute(builder: (_) => const ContatoView());

      case "/cliente_view":
        return MaterialPageRoute(builder: (_) => const ClienteView());

      default:
        _erroRota();
    }

    throw '';
  }

  static Route<dynamic> _erroRota() {
    return MaterialPageRoute(builder: (_) {
      return Scaffold(
        appBar: AppBar(
          title: const Text("Erro Rota"),
        ),
        body: const Text("Tela não encontada!"),
      );
    });
  }
}
