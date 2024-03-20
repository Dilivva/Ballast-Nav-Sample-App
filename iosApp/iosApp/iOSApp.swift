import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    init() {
        KoinKt.doInitKoin()
    }

    var body: some Scene {
		WindowGroup {
            ContentView().onOpenURL{ link in
                DeepLinkResult.companion.setUrl(url: link.absoluteString)
            }
		}
	}
}
